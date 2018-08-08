<?php include ('functions.php');
$id=$_GET['id'];
$nombres=$_GET['nombres'];


ejecutarSQLCommand("INSERT INTO  `usuarios` (id,valor) VALUES('$id','$nombres')

 ON DUPLICATE KEY UPDATE `valor`= '$nombres';");
echo "registro exitoso";

 ?>