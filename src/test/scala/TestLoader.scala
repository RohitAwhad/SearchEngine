import com.demo.Loader.buildTernaryTree
import com.demo.TernarySearchTree
import org.scalatest.{BeforeAndAfterAllConfigMap, ConfigMap}
import org.scalatest.funsuite.AnyFunSuite

class TestLoader extends AnyFunSuite with BeforeAndAfterAllConfigMap{
  var sentenceToSearch:String = _
  var wordDBCountExpected:Integer = _
  var wordDB1CountExpected:Integer = _

  override def beforeAll(configMap: ConfigMap): Unit = {

    sentenceToSearch = configMap.getRequired[String]("sentenceToSearch")
    wordDBCountExpected = configMap.getRequired[String]("wordDBCountExpected").toInt
    wordDB1CountExpected = configMap.getRequired[String]("wordDB1CountExpected").toInt
  }
  def validateSearchEngine(): Boolean = {

    var tree = new TernarySearchTree()
    val wordDB = Array("car","bus","banana","city","person")
    val wordDB1 = Array("carr","bus","bananaa","cityy","personn")

    /**
     *  Note wordDBCountExpected is linked with file1
     *  and wordDB1CountExpected is linked with file2
     */
    tree = buildTernaryTree(tree,wordDB,"file1")
    tree = buildTernaryTree(tree,wordDB1,"file2")
    var map = new java.util.HashMap[String,Integer]
    val searchWords = sentenceToSearch.split("\\s")
    for(word <- searchWords){
      val set =tree.get(word.trim)
      if(!tree.get(word.trim).isEmpty) {
        set.foreach(x => {
          if(map.containsKey(x)) {
            val cnt = map.get(x)+1
            map.put(x,cnt)
          }
          else {
            map.put(x,1)
          }
        })

      }
    }

    (map.get("file1") == wordDBCountExpected) && (map.get("file2") == wordDB1CountExpected)

  }
  test("validateSearchEngine"){
    assert(validateSearchEngine())
  }
}
