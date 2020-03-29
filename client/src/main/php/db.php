<?php 

$dbHost = "localhost";
$dbName = "bringalong";
$dbUser = "bringalong";
$dbPassword = "geheimespw";

function connect()
{
    global $dbHost, $dbName, $dbUser, $dbPassword;
    $dbconn = pg_connect("host=$dbHost dbname=$dbName user=$dbUser password=$dbPassword");
    return $dbconn;
}

function fetchAll($query)
{
    $dbconn = connect();

    //echo $query;
    $result = pg_query($query);

    $arr = pg_fetch_all($result);
    
    pg_close($dbconn);

    if($arr === false)
    {
        return array();
    }
    return $arr;
}

?>