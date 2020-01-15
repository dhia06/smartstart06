<?php

namespace FormationBundle\Controller;

use Doctrine\Common\Persistence\PersistentObject;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use FormationBundle\Entity\Formation;
use FormationBundle\Form\FormationType;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;


class FormationController extends Controller
{
    public function AjouterFormationAction(Request $request)
    {
        $formation = new Formation();
        $test = "ajout";
        $form = $this->createForm(FormationType::class, $formation);
        $form = $form->handleRequest($request);
        if ($form->isValid()) {
            $em = $this->getDoctrine()->getManager();
            $em->persist($formation);
            $em->flush();
            return $this->redirectToRoute('formation_afficheformation');
        }
        return $this->render('@Formation/Default/ajoutformation.html.twig', array('form' => $form->createView(), 'test' => $test));
    }

    public function afficheFormationAction()
    {
        //if(($this->container->get('security.authorization_checker')->isGranted('ROLE_CLIENT'))){
        // throw new AccessDeniedException('Access Denied!!!!!');
        //}
        //else{
        $em = $this->getDoctrine();
        $tab = $em->getRepository(Formation::class)->findAll();
        return $this->render('@Formation/Default/afficheformation.html.twig', array('formation' => $tab));
    }
    public function supprimerformationAction($id)
    {
        $em=$this->getDoctrine()->getManager();

        $tab = $em->getRepository(Formation::class)->find($id);
        $em->remove($tab);
        $em->flush();
        return $this->redirectToRoute('formation_afficheformation');

    }
    public function updateformationAction($id,Request $request){
        //1- recuperation de l objet
        $em=$this->getDoctrine()->getManager();

        $formation=$em->getRepository(Formation::class)->find($id);

        //2- preparation du form
        $test="modify";
        $form=$this->createForm(FormationType::class,$formation);

        //2.1 récupération des données
        $form=$form->handleRequest($request);

        //3 sauvegarde des données
        if($form->isValid()){

            $em->flush();

            return $this->redirectToRoute('formation_afficheformation',array('id'=>$id));
        }

        return $this->render('@Formation/Default/ajoutformation.html.twig',array('form'=>$form->createView(),'test'=>$test));

    }
    public function searchDBAction(Request $request)
    {

        $em = $this->getDoctrine()->getManager();
        $requestString = $request->get('q');
        $entities =  $em->getRepository(Formation::class)->findEntitiesByDescription($requestString);
        if(!$entities) {
            $result['entities']['error'] = "No results matche with your search ";
        } else {
            $result['entities'] = $this->getRealEntities($entities);
        }
        return new Response(json_encode($result));

    }

    public function getRealEntities($entities){
        foreach ($entities as $entity){
            $realEntities[$entity->getId()] = [$entity->getNom()];
        }
        return $realEntities;
    }
    public function nb_clickAction($id)
    {
        $em = $this->getDoctrine()->getManager();
        $formation = $em->getRepository(Formation::class)->find($id);

        $formation->setNbrPlaces($formation->getNbrPlaces() -1);
        $em->persist($formation);
        $em->flush();

        return $this->redirectToRoute('formation_afficheformation', array('id' => $formation->getId()));


    }


}