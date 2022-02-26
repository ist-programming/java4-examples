<?php

use App\MainController;

require_once __DIR__ . '/../vendor/autoload.php';

use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;

$request = Request::createFromGlobals();

$routes = [
    '/' => MainController::class,
];

$uri = $request->getRequestUri();
if(!isset($routes[$uri])){
    $response = new Response('No page found', Response::HTTP_NOT_FOUND);
}
else{
    $controller = new $routes[$uri]();
    $response = $controller->doAction($request);
}

$response->send();
