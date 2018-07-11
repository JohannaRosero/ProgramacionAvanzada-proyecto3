<!DOCTYPE html>
<html lang="en">
<head>


	  <meta name="viewport" content="initial-scale=1.0, user-scalable=no">
   <meta charset="utf-8">

 <style>
      html, body{
        height: 100%;
        margin: 0px;
        padding: 0px
      }
      .botones {
       width: 80px; 
       height: 80px;
       color:white;       
       background-color: black;
       font-size: 50px;

      }
    </style>    
</head>	
<body>


 <div>
   <h1><strong>	SALA DE CINE</strong></h1>
 </div>
 <table border=0>
  <tr> 
    <td><input type=button value="" name="btn1" id="btn1" class="botones" onClick="jugada(1)"/></td>
    <td><input type=button value="" name="btn2" id="btn2" class="botones" onClick="jugada(2)"/></td>
    <td><input type=button value="" name="btn3" id="btn3" class="botones" onClick="jugada(3)"/></td>
	<td><input type=button value="" name="btn4" id="btn4" class="botones" onClick="jugada(4)"/></td>
    <td><input type=button value="" name="btn5" id="btn5" class="botones" onClick="jugada(5)"/></td>
    <td><input type=button value="" name="btn6" id="btn6" class="botones" onClick="jugada(6)"/></td>
	<td><input type=button value="" name="btn7" id="btn7" class="botones" onClick="jugada(7)"/></td>
    <td><input type=button value="" name="btn8" id="btn8" class="botones" onClick="jugada(8)"/></td>
    <td><input type=button value="" name="btn9" id="btn9" class="botones" onClick="jugada(9)"/></td>
	
  </tr>
  <tr>
    <td><input type=button value="" name="btn10" id="btn10" class="botones" onClick="jugada(10)"/></td>
    <td><input type=button value="" name="btn11" id="btn11" class="botones" onClick="jugada(11)"/></td>
    <td><input type=button value="" name="btn12" id="btn12" class="botones" onClick="jugada(12)"/></td>
	<td><input type=button value="" name="btn13" id="btn13" class="botones" onClick="jugada(13)"/></td>
    <td><input type=button value="" name="btn14" id="btn14" class="botones" onClick="jugada(14)"/></td>
    <td><input type=button value="" name="btn15" id="btn15" class="botones" onClick="jugada(15)"/></td>
	<td><input type=button value="" name="btn16" id="btn16" class="botones" onClick="jugada(16)"/></td>
    <td><input type=button value="" name="btn17" id="btn17" class="botones" onClick="jugada(17)"/></td>
    <td><input type=button value="" name="btn18" id="btn18" class="botones" onClick="jugada(18)"/></td>
  </tr>
  <tr>
    <td><input type=button value="" name="btn19" id="btn19" class="botones" onClick="jugada(19)"/></td>
    <td><input type=button value="" name="btn20" id="btn20" class="botones" onClick="jugada(20)"/></td>
    <td><input type=button value="" name="btn21" id="btn21" class="botones" onClick="jugada(21)"/></td>
	<td><input type=button value="" name="btn22" id="btn22" class="botones" onClick="jugada(22)"/></td>
    <td><input type=button value="" name="btn23" id="btn23" class="botones" onClick="jugada(23)"/></td>
    <td><input type=button value="" name="btn24" id="btn24" class="botones" onClick="jugada(24)"/></td>
	<td><input type=button value="" name="btn25" id="btn25" class="botones" onClick="jugada(25)"/></td>
    <td><input type=button value="" name="btn26" id="btn26" class="botones" onClick="jugada(26)"/></td>
    <td><input type=button value="" name="btn27" id="btn27" class="botones" onClick="jugada(27)"/></td>
  </tr>
    <tr>
    <td><input type=button value="" name="btn28" id="btn28" class="botones" onClick="jugada(28)"/></td>
    <td><input type=button value="" name="btn29" id="btn29" class="botones" onClick="jugada(29)"/></td>
    <td><input type=button value="" name="btn30" id="btn30" class="botones" onClick="jugada(30)"/></td>
	<td><input type=button value="" name="btn31" id="btn31" class="botones" onClick="jugada(31)"/></td>
    <td><input type=button value="" name="btn32" id="btn32" class="botones" onClick="jugada(32)"/></td>
    <td><input type=button value="" name="btn33" id="btn33" class="botones" onClick="jugada(33)"/></td>
	<td><input type=button value="" name="btn34" id="btn34" class="botones" onClick="jugada(34)"/></td>
    <td><input type=button value="" name="btn35" id="btn35" class="botones" onClick="jugada(35)"/></td>
    <td><input type=button value="" name="btn36" id="btn36" class="botones" onClick="jugada(36)"/></td>
  </tr>
  
</table>
<script src="http://code.jquery.com/jquery-1.11.1.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/socket.io/2.0.0/socket.io.js"></script>
<script>

		var jugador=document.getElementById("btn36");
		var colores = new Array(36);

		var socket= io();

		function jugada(cuadro){      
		  //esto es para percibir el cambio de valor
		  socket.emit("jugada",{id: jugador.value,id2:cuadro});      
		}   
 
        socket.on('jugada2',function(data){
		   document.getElementById("btn"+data.id2).disabled=true; 
		   document.getElementById("btn"+data.id2).style="background-color: #FF0000";
         });         
 </script>  
</body>


</html>

