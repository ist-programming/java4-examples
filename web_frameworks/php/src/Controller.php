<?php

namespace App;

use Symfony\Component\HttpFoundation\Request;

interface Controller
{
    public function doAction(Request $req);
}