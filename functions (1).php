<?php 
header( 'Content-Type: text/html;charset=utf-8' );


function ejecutarSQLCommand($commando){
 
  $mysqli = new mysqli("localhost", "root", "", "tutorial27");

/* check connection */
if ($mysqli->connect_errno) {
    printf("Connect failed: %s\n", $mysqli->connect_error);
    exit();
}

if ( $mysqli->multi_query($commando)) {
     if ($resultset = $mysqli->store_result()) {
    	while ($row = $resultset->fetch_array(MYSQLI_BOTH)) {
    		
    	}
    	$resultset->free();
     }
    
   
}





$mysqli->close();
}

function getSQLResultSet($commando){
$db_name = "tutorial27";
$con=@mysql_connect("localhost", "root", "", "tutorial27") or die("cannot connect");

mysql_select_db($db_name) or die("cannot select DB");
$result = mysql_query($commando,$con);
$json = array();


if(mysql_num_rows($result)){
	while($row=mysql_fetch_object($result)){
		$json[]=$row;		
	}
}
mysql_close($con);
return $json;

}


?>
