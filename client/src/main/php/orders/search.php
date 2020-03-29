<?php
    require __DIR__ . '/../auth.php';
    require __DIR__ . '/../db.php';

    $requestUrl = $_SERVER['REQUEST_URI'];
    $urlParts = explode("/", $requestUrl);

    $long = $urlParts[count($urlParts)-1];
    $lat = $urlParts[count($urlParts)-2];

    $query = 'SELECT * FROM (SELECT "users"."street", "users"."zipcode", "users"."city", "orders"."id", "orders"."text", "orders"."dropHint", "orders"."deadline", "orders"."estimatedAmount", "orders"."currency", ST_Distance("users"."coordinates", ST_GeometryFromText(\'Point(' . pg_escape_string($long) . " " . pg_escape_string($lat) . ')\')) as "distance" FROM orders join users on("orders"."userId" = "users"."id") where "orders"."acceptedUserId" is NULL) r order by distance limit 50;';
    $arr = fetchAll($query);
    
    echo json_encode(array("orders" => $arr));
?>