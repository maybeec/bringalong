<?php
    require __DIR__ . '/../auth.php';
    require __DIR__ . '/../db.php';

    $claims = checkAuth(false);

    $requestUrl = $_SERVER['REQUEST_URI'];
    $urlParts = explode("/", $requestUrl);

    $id = $urlParts[count($urlParts)-1];

    $query = 'SELECT "users"."id" as "userId", "users"."name", "users"."street", "users"."zipcode", "users"."city", "users"."number", ST_X("users"."coordinates"::geometry) AS lng, ST_Y("users"."coordinates"::geometry) AS lat, "orders"."id", "orders"."text", "orders"."dropHint", "orders"."deadline", "orders"."estimatedAmount", "orders"."currency", "orders"."acceptedUserId" FROM orders join users on("orders"."userId" = "users"."id") where "orders"."id" = \'' . pg_escape_string($id) . '\'';
    $arr = fetchAll($query);
    
    $value = $arr[0];

    $result = array(
                        "order" => array(
                            "id" => $value["id"],
                            "text" => $value["text"],
                            "dropHint" => $value["dropHint"],
                            "deadline" => $value["deadline"],
                            "estimatedAmount" => $value["estimatedAmount"],
                            "currency" => $value["currency"],
                            "accepted" => !!$value["acceptedUserId"],
                            "acceptedByCurrentUser" => false
                        ),
                        "user" => array(
                            "id" => $value["userId"],
                            "street" => $value["street"],
                            "number" => null,
                            "zipcode" => $value["zipcode"],
                            "city" => $value["city"],
                            "lat" => null,
                            "lng" => null,
                            "name" => null
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

    echo json_encode($result);
?>