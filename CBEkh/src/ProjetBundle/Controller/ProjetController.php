<?php

namespace ProjetBundle\Controller;
use MainBundle\Entity\Projet;
use MainBundle\Form\ProjetType;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Component\HttpFoundation\Request;

class ProjetController extends Controller
{
    public function ajoutprojetAction(Request $request){
        $test="ajout";
        $projet=new Projet();

        $form=$this->createForm(ProjetType::class,$projet);
        $form=$form->handleRequest($request);
        if($form->isValid()){
            $em=$this->getDoctrine()->getManager();
            $em->persist($projet);
            $em->flush();
            return $this->redirectToRoute('projet_afficheprojet');
        }
        return $this->render('@Projet/Projet/ajoutprojet.html.twig',array('form'=>$form->createView(),'test'=>$test));
    }

    public function afficheprojetAction(Request $request)
    {
        //if(($this->container->get('security.authorization_checker')->isGranted('ROLE_CLIENT'))){
        // throw new AccessDeniedException('Access Denied!!!!!');
        //}
        //else{
        $em = $this->getDoctrine();
        $tab = $em->getRepository(Projet::class)->findAll();
        $paginator  = $this->get('knp_paginator');

        $pagination = $paginator->paginate($tab,
            $request->query->get('page',1),
            $request->query->get('limit',1)

        );
        return $this->render('@Projet/Projet/afficheprojet.html.twig', array(
            'formulaires' => $pagination ,));
/*        return $this->render('@Projet/Projet/afficheprojet.html.twig', array('formulaires' => $tab));*/
    }

    public function deleteprojetAction($id){
        $em=$this->getDoctrine()->getManager();
        $projet=$em->getRepository(Projet::class)->find($id);
        $em->remove($projet);
        $em->flush();
        return $this->redirectToRoute('projet_afficheprojet');

    }

    public function updateprojetAction($id,Request $request){
        //1- recuperation de l objet
        $em=$this->getDoctrine()->getManager();

        $projet=$em->getRepository(Projet::class)->find($id);

        //2- preparation du form
        $test="modify";
        $form=$this->createForm(ProjetType::class,$projet);

        //2.1 récupération des données
        $form=$form->handleRequest($request);

        //3 sauvegarde des données
        if($form->isValid()){

            $em->flush();

            return $this->redirectToRoute('projet_afficheprojet');
        }

        return $this->render('@Projet/Projet/ajoutprojet.html.twig',array('form'=>$form->createView(),'test'=>$test));

    }


}
