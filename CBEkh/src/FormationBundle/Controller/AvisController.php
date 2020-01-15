<?php

namespace FormationBundle\Controller;

use FormationBundle\Entity\Avis;
use FormationBundle\Form\AvisType;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;

class AvisController extends Controller
{
    public function AjouterAvisAction(Request $request)
    {
        $formation = new Avis();
        $test = "ajout";
        $form = $this->createForm(AvisType::class, $formation);
        $form = $form->handleRequest($request);
        if ($form->isValid()) {
            $em = $this->getDoctrine()->getManager();
            $em->persist($formation);
            $em->flush();
            return $this->redirectToRoute('avis_show');
        }
        return $this->render('@Formation/Default/avisajout.html.twig', array('form' => $form->createView(), 'test' => $test));
    }

    public function afficheAvisAction()
    {

        $em = $this->getDoctrine();
        $tab = $em->getRepository(Avis::class)->findAll();
        return $this->render('@Formation/Default/afficheavis.html.twig', array('formation' => $tab));
    }
    public function supprimerAvisAction($id)
    {
        $em=$this->getDoctrine()->getManager();

        $tab = $em->getRepository(Avis::class)->find($id);
        $em->remove($tab);
        $em->flush();
        return $this->redirectToRoute('avis_show');

    }
    public function updateAvisAction($id,Request $request){
        //1- recuperation de l objet
        $em=$this->getDoctrine()->getManager();

        $formation=$em->getRepository(Avis::class)->find($id);

        //2- preparation du form
        $test="modify";
        $form=$this->createForm(AvisType::class,$formation);

        //2.1 récupération des données
        $form=$form->handleRequest($request);

        //3 sauvegarde des données
        if($form->isValid()){

            $em->flush();

            return $this->redirectToRoute('avis_show');
        }

        return $this->render('@Formation/Default/avisajout.html.twig',array('form'=>$form->createView(),'test'=>$test));

    }


}
