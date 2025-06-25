<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <title>home 화면</title>
   </head>
   <body>
      <h2>Spring Data JPA</h2>
      <ul>
         <!-- 최초 실행시 test1부터 5까지 추가 후 테스트. 
         재시작시 초기화되므로 none으로 변경. -->
         <li><a href="/insert.do">데이터 추가</a></li>
         <li><a href="./selectAll.do">전체 조회</a></li>
         <li><a href="./selectById.do?id=1">
               개별 조회 - byId</a></li>
         <li><a href="./selectByName.do?name=을지문덕">
               개별 조회 - byName</a></li>
         <li><a href="./selectByEmail.do?email=test7@test.com">
               개별조회 - byEmail</a></li>
         <li><a href="./selectByNameLike.do?name=김">
               리스트 조회 - Name Like</a></li>
         <li><a href="./selectByNameLikeNameDesc.do?name=김">
               리스트 조회 - Name Like Name Desc</a></li>
         <li><a href="./selectByNameLikeOrder.do?name=김">
               리스트 조회 - Name Like Name Desc(Sort사용)</a></li>
      </ul>
   </body>
</html>