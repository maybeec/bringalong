<?php
    require __DIR__ . '/../auth.php';
    require __DIR__ . '/../db.php';

    $claims = checkAuth(false);

    $requestUrl = $_SERVER['REQUEST_URI'];
    $urlParts = explode("/", $requestUrl);

    $long = $urlParts[count($urlParts)-1];
    $lat = $urlParts[count($urlParts)-2];

    $query = 'SELECT * FROM (SELECT "users"."id" as "userId", "users"."name", "users"."street", "users"."zipcode", "users"."city", "users"."number", ST_X("users"."coordinates"::geometry) AS lng, ST_Y("users"."coordinates"::geometry) AS lat, "orders"."id", "orders"."text", "orders"."dropHint", "orders"."deadline", "orders"."estimatedAmount", "orders"."currency", ST_Distance("users"."coordinates", ST_GeometryFromText(\'Point(' . pg_escape_string($long) . " " . pg_escape_string($lat) . ')\')) as "distance", "orders"."acceptedUserId" FROM orders join users on("orders"."userId" = "users"."id") where "orders"."acceptedUserId" is NULL) r order by distance limit 50;';
    $arr = fetchAll($query);
    
    $response = array();

    foreach($arr as $value)
    {
        $result = array(
                            "order" => array(
                                "id" => $value["id"],
                                "text" => $value["text"],
                                "dropHint" => $value["dropHint"],
                                "deadline" => $value["deadline"],
                                "estimatedAmount" => $value["estimatedAmount"],
                                "currency" => $value["currency"]
                            ),
                            "user" => array(
                                "id" => $value["userId"],
                                "text" => $value["text"],
                                "dropHint" => $value["dropHint"],
                                "deadline" => $value["deadline"],
                                "estimatedAmount" => $value["estimatedAmount"],
                                "currency" => $value["currency"],
                                "accepted" => !!$value["acceptedUserId"],
                                "acceptedByCurrentUser" => false
                            )
                        );

        if($claims && $claims["userId"] == $value["acceptedUserId"])
        {
            $result["user"]["name"] = $value["name"];
            $result["user"]["number"] = $value["number"];
            $result["user"]["lat"] = $value["lat"];
            $result["user"]["lng"] = $value["lng"];
            $result["order"]["acceptedByCurrentUser"] = true;
        }
        $response[] = $result;
    }

    echo json_encode(array("orders" => $response));
?>