<?php
    require __DIR__ . '/../auth.php';
    require __DIR__ . '/../db.php';
    
    $claims = checkAuth();

    $query = "SELECT id, ST_X(coordinates::geometry) AS lng, ST_Y(coordinates::geometry) AS lat FROM users where id::text = '" . pg_escape_string($claims["userId"]) . "';";

    $arr = fetchAll($query);

    if(count($arr) != 1)
    {
        http_response_code(404);
        exit ();
    }
    echo json_encode(array("user" => $arr[0]));
?>