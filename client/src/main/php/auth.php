<?php
require __DIR__ . '/vendor/autoload.php';
use \Firebase\JWT\JWT;

$privateKey = <<<EOD
-----BEGIN RSA PRIVATE KEY-----
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
-----END RSA PRIVATE KEY-----
EOD;

$publicKey = <<<EOD
-----BEGIN PUBLIC KEY-----
MIICIjANBgkqhkiG9w0BAQEFAAOCAg8AMIICCgKCAgEAyBKA2KCm/JeWq85pD9In
4oBlUbmMz3i9a5MAFToG1dh7Hh1mlyPqnw9EJG0xq4ftnQS2Bl6hYcbptICpF9z3
Gy+doC74ez3HnjgdxAAT5EBEEM/5fJhiJs37KjzHujGAlg2WaxuxRCjGgW3cOLkW
w8p5i99VDHtcpt/tPL86tsj1jgWGG049yOgCgAekSsWKdJMMq9JYrH6i1Atf2FrA
45118NGInPhAAA78L04Dzz/g1mDYvKjIZIAefSTicS2NqjPcSSfBBV/+lq1zOZos
BMUc8r99mX6HCCdEumZXQxSAb8afop3CtmicgB8nXd4eQ5hQZMTx02D9Ehm0lFA5
v/gyCK9JINVlqNxZZ33hjyvFfx86xb353/QqaudStKSbkC9AsqMssOrKKUHOirgg
Ogt1GC8q+KFYdOsiU2pOqt1z8PDQcNxOilENyfEvZjCXyTAIeITcXq19TVrlLFBP
rTi+ttT1Dgj4Kq9Ez7QyYR9AWkZnpKaxnTAUt74sxESg5GKQf+pp4zEXOyh6CaFm
gReg9j8pAwzRyZ4b7F/QKJPnN5G58kzMBlc9lEaSNPQwSBUO8dKeFeei96w9y0dX
G5sVxZGT8hNKGRFo60qGSBElLq9D0ZgQ0C+4GlgLIvnN6Y96+GU36mjF/HX04g76
QNFiBvqK3RupgaRc/2F+ha8CAwEAAQ==
-----END PUBLIC KEY-----
EOD;

function checkAuth($needed = true)
{
    try
    {
        global $publicKey;
        $headers = getallheaders();
        $header = "";
        if(array_key_exists('authorization',$headers)) 
        {
            $header = $headers['authorization'];
        }
        else if(array_key_exists('Authorization',$headers)) 
        {
            $header = $headers['Authorization'];
        }
        if($header === "")
        {
            if($needed)
            {
                http_response_code(401);
                exit ();
            }
            else
            {
                return false;
            }
        }
        $jwt = substr($header, 7);
        $decoded = @JWT::decode($jwt, $publicKey, array('RS256'));

        if((time() - $decoded->iat) > 36000)
        {
            if(!$needed)
            {
                http_response_code(401);
                exit ();
            }
        } else {
            return get_object_vars($decoded);
        }
    }
    catch(Exception $e)
    {
        if($needed)
        {
            throw $e;
        }
    }
    return false;
}

?>