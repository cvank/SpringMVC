 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  
<h1>Employees List</h1>  
<table border="2" width="70%" cellpadding="2">  
<tr><th>Id</th><th>First Name</th><th>Last Name</th><th>Email</th></tr>  
   <c:forEach var="candidates" items="${list}">   
   <tr>
   <td>${candidates.id}</td>  
   <td>${candidates.first_name}</td>  
   <td>${candidates.last_name}</td>  
   <td>${candidates.email}</td>  
   </tr>  
   </c:forEach>  
   </table>  
   <br/>  
 <!--   <a href="empform">Add New Employee</a>   -->