<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2/18/2022
  Time: 11:47 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
  <head>
    <title>The Word Clock</title>
    <style type="text/css">
      select {
        width: 200px;
        height: 20px;
      }
    </style>
  </head>
  <body>
<h2>Current Local Times Around The Wold</h2>
  <span>Current time in ${city}: <strong>${date}</strong></span>
  <form id="locale" action="world-clock" method="get">
    <select name="city" onchange="document.getElementById('locale').submid()">
      <option value="Asia/Ho_Chi_Minh" selected>Select a city</option>
      <option value="Asia/Ho_Chi_Minh">Ho Chi Minh</option>
      <option value="Singapore">Singapore</option>
      <option value="Asia/Hong_Kong">Hong Kong</option>
      <option value="Asia/Tokyo">Tokyo</option>
      <option value="Asia/Seoul">Seoul</option>
      <option value="Europe/London">London</option>
      <option value="Europe/Madrid">Madrid</option>
      <option value="America/New_York">New York</option>
      <option value="Australia/Sydney">Sydney</option>
      <option value="Argentina/Buenos_Aires">Buenos Aires</option>
    </select>
  </form>
  </body>
</html>
