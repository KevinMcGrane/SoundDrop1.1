<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Chapter 4 : Data Types - Plain Text Response</title>
<script type="text/javascript">
 
function encodeValue(val)
{
 var encodedVal;
 if (!encodeURIComponent)
 {
   encodedVal = escape(val);
   /* fix the omissions */
   encodedVal = encodedVal.replace(/@/g, '%40');
   encodedVal = encodedVal.replace(/\//g, '%2F');
   encodedVal = encodedVal.replace(/\+/g, '%2B');
 }
 else
 {
   encodedVal = encodeURIComponent(val);
   /* fix the omissions */
   encodedVal = encodedVal.replace(/~/g, '%7E');
   encodedVal = encodedVal.replace(/!/g, '%21');
   encodedVal = encodedVal.replace(/\(/g, '%28');
   encodedVal = encodedVal.replace(/\)/g, '%29');
   encodedVal = encodedVal.replace(/'/g, '%27');
 }
 /* clean up the spaces and return */
 return encodedVal.replace(/\%20/g,'+'); 
}
 
function createXHR()
{
   try { return new XMLHttpRequest(); } catch(e) {}
   try { return new ActiveXObject("Msxml2.XMLHTTP.6.0"); } catch (e) {}
   try { return new ActiveXObject("Msxml2.XMLHTTP.3.0"); } catch (e) {}
   try { return new ActiveXObject("Msxml2.XMLHTTP"); } catch (e) {}
   try { return new ActiveXObject("Microsoft.XMLHTTP"); } catch (e) {}
 
   return null;
}
 
function sendRequest(url, payload)
{
    var xhr = createXHR();
 
    if (xhr)
     {
       xhr.open("GET",url + "?" + payload,true);
       xhr.onreadystatechange = function(){handleResponse(xhr);};
       xhr.send(null);
     }
 
}
 
function handleResponse(xhr)
{
  if (xhr.readyState == 4  && xhr.status == 200)
    {
      var responseOutput = document.getElementById("responseOutput");
     
     var responseText = xhr.responseText.replace(/<([^>]*)>/g, "&lt;$1&gt;");
     responseText = responseText.replace(/\n/g, "<br/>");
         
     responseOutput.innerHTML = "<h3>Response Text</h3>" + responseText;
     responseOutput.innerHTML += "<h3>Processed</h3>";
     responseOutput.innerHTML += xhr.responseText;
    }
}
 
 
function rate(rating)
{
    var url = "http://localhost:8080/rate";
    var payload = "rating=" + encodeValue(rating);
    payload += "&response=text";
    sendRequest(url, payload);
}
 
window.onload = function () 
{ 
 var radios = document.getElementsByName('rating');
 for (var i = 0; i < radios.length; i++)
  {
   radios[i].onclick = function (){rate(this.value);}; 
  }
};
</script>
 
</head>
<body>
<h3>How do you feel about Ajax?</h3>
<form action="#" method="get" name="ratingForm">
<em>Hate It - </em> [
<input type="radio" name="rating" value="1" /> 1
<input type="radio" name="rating" value="2" /> 2
<input type="radio" name="rating" value="3" /> 3
<input type="radio" name="rating" value="4" /> 4
<input type="radio" name="rating" value="5" /> 5
] <em> - Love It</em>
 
</form>
<br />
</head>
<body>

</body>
</html>