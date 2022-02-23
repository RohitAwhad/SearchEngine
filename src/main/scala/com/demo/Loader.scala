package com.demo
import java.util.Scanner
import java.io.File
import com.demo.Node


object Loader {

  def buildTernaryTree(tree: TernarySearchTree, wordDB: Array[String],filename:String):TernarySearchTree = {
    for(str <- wordDB){
      tree.put(str,filename)
    }

    tree
  }
  def getListOfFiles(dir: String):List[File] = {
    val d = new File(dir)
    if (d.exists && d.isDirectory) {
      d.listFiles.filter(_.isFile).toList
    } else {
      List[File]()
    }
  }
  def readTextFile(filename: File): Seq[String] = {
    val bufferedSource = io.Source.fromFile(filename)("UTF-8")
    val lines = (for (line <- bufferedSource.getLines()) yield line).toList
    bufferedSource.close
    lines
  }
  def main(args: Array[String]): Unit = {
    /*var variable_name : Char  = 'I';
     var obj = new Node(variable_name)
    println(obj.character)*/
    var tree = new TernarySearchTree()

    val scr = new Scanner(System.in)
    val files = getListOfFiles(args(0))
    for(file <- files){
     val lines=  readTextFile(file)
      val filename = file.toString.substring(file.toString.lastIndexOf("\\")+1)

      for(line <- lines){
        if(!"".equalsIgnoreCase(line.trim)){
          val wordDB = line.replaceAll("\\.","").replaceAll(",","").split("\\s+")
          tree = buildTernaryTree(tree,wordDB,filename)
        }

      }
    }
    var map = new java.util.HashMap[String,Integer]
    while(true){
      map = new java.util.HashMap[String,Integer]
      print("\nSearch > ")
      val searchText = scr.nextLine()
      val searchWords = searchText.split("\\s")
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
      import scala.collection.JavaConversions._
      for (entry <- map.entrySet) {
        print(entry.getKey)
        print("  :  ")
        print((entry.getValue.doubleValue()/searchWords.size)*100)
        println("")
      }
    }

  }
}
