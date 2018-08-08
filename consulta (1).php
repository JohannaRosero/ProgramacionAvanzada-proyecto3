<?php
include('functions.php');
$id=$_GET["id"];

$json = array();
if($row=getSQLResultSet("SELECT `id` FROM `usuarios` WHERE `valor`='1'")){

		echo json_encode($row);
	
}

?>


