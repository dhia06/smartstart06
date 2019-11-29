<?php

namespace LastBundle\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\Controller;

class DefaultController extends Controller
{
    public function indexAction()
    {
        return $this->render('LastBundle:Default:index.html.twig');
    }
}
