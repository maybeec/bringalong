<?php
    require __DIR__ . '/../auth.php';
    require __DIR__ . '/../db.php';
    
    $claims = checkAuth();

    $request = json_decode(file_get_contents('php://input'), true);

    $timestamp = strtotime($request["order"]["deadline"] ?? "");

    $query = "INSERT INTO orders (\"userId\", \"text\", \"dropHint\", \"deadline\", \"estimatedAmount\", \"currency\") VALUES (uuid('" . pg_escape_string($claims["userId"]) . "'), '" . pg_escape_string($request["order"]["text"] ?? "") . "', '" . pg_escape_string($request["order"]["dropHint"] ?? "") . "', to_timestamp(" . $timestamp . ") AT TIME ZONE 'UTC', " . pg_escape_string($request["order"]["estimatedAmount"] ?? -1) . ", '" . pg_escape_string($request["order"]["currency"] ?? "") . "');";
    
    if(!nonQuery($query))
    {
        http_response_code(400);
        exit ();
    }
?>