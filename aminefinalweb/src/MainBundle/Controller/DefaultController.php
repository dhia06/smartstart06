<?php

namespace MainBundle\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\Controller;

class DefaultController extends Controller
{
    public function indexAction()
{
    return $this->render('@Main/Default/index.html.twig');
}
    public function templateAction()
    {
        $user = $this->container->get('security.token_storage')->getToken()->getUser();
        if ($user === 'anon.') return $this->render('feedback/test.html.twig');

        switch ($user->getRoles()[0]) {
            case "ROLE_ADMIN":
                return $this->render('feedback/test.html.twig');
                break;
            case "ROLE_FREELANCER":
                return $this->render('feedback/test.html.twig');
                break;
        }
    }
}
