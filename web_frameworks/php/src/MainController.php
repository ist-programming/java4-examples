<?php

namespace App;

use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;

class MainController implements Controller
{
    public function doAction(Request $req)
    {
        $content = 'Hello from MainController';
        return new Response($content, Response::HTTP_OK);
    }
}