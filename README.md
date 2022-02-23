# SearchEngine

<b>Ranking Strategy</b> <br><br>
● The rank score must be 100% if a file contains all the words <br>
● It must be 0% if it contains none of the words <br>
● It should be between 0 and 100 if it contains only some of the words but the exact ranking formula is up to you <br>
to choose and implement

Things to consider in your implementation <br><br>
● What constitutes a word - <b>Any space seperated words in a line.</b> <br>
● What constitutes two words being equal (and matching) - <b>exact match of word is considered as match</b><br>
  
  Note: list of the top 10 (max) matching filenames in rank order is not implemented but current implemenatation displays all file and its corresponding score as shown below.<br>
  
  
  <b>Command to run program from root directory </b><br>
  D:\study\SearchEngine> scala -cp target\scala-2.11\searchengine_2.11-0.1.jar com.demo.Loader resources
  
  
