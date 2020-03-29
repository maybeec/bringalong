<?php
    require __DIR__ . '/../vendor/autoload.php';
    use \Firebase\JWT\JWT;
    require __DIR__ . '/../auth.php';
    require __DIR__ . '/../db.php';
    
    $request = json_decode(file_get_contents('php://input'), true);
    //print_r($request);

    $users = fetchAll("SELECT * FROM users where email = '" . pg_escape_string($request['login'])."';");
    if(count($users) != 1)
    {
        http_response_code(401);
        exit ();
    }

    //TODO: check pw

    $payload = array(
        "userId" => $users[0]["id"],
        "iat" => time()
    );

    $jwt = JWT::encode($payload, $privateKey, 'RS256');

    echo json_encode(array("token" => $jwt));
?>