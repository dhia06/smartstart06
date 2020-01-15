<?php

namespace ProjetBundle\Controller;
use MainBundle\Entity\Formulaire;
use MainBundle\Entity\Projet;
use MainBundle\Form\FormulaireType;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Component\HttpFoundation\Request;

class FormulaireController extends Controller
{


    public function ajoutformulaireAction(Request $request,$id){
        $test="ajout";
        $formulaire=new Formulaire();
        $formulaire->setNom($this->getUser()->getNom());
        $formulaire->setPrenom($this->getUser()->getPrenom());
        $formulaire->setMail($this->getUser()->getEmail());
        $em=$this->getDoctrine()->getManager();
        $projet=$em->getRepository(Projet::class)->find($id);
        $formulaire->setNomduprojet($projet->getTitre());
        $formulaire->setIdprojet($projet);
        $form=$this->createForm(FormulaireType::class,$formulaire);
        $form=$form->handleRequest($request);
        if($form->isValid()){
            $projet->setMontant($projet->getMontant()-$formulaire->getMontantform());
            $em->persist($formulaire);
            $em->flush();

            return $this->redirectToRoute('projet_afficheformulaire');
        }
        return $this->render('@Projet/Formulaire/ajoutformulaire.html.twig',array('form'=>$form->createView(),'test'=>$test));
    }

    public function afficheformulaireAction()
    {
        //if(($this->container->get('security.authorization_checker')->isGranted('ROLE_CLIENT'))){
           // throw new AccessDeniedException('Access Denied!!!!!');
        //}
        //else{
            $em = $this->getDoctrine();
            $tab = $em->getRepository(Formulaire::class)->findAll();
            return $this->render('@Projet/Formulaire/afficheformulaire.html.twig', array('formulaires' => $tab));
        }

        public function deleteformulaireAction($id){
        $em=$this->getDoctrine()->getManager();
        $formulaire=$em->getRepository(Formulaire::class)->find($id);
        $projet=$em->getRepository(Projet::class)->find($formulaire->getIdprojet()->getId());
        $projet->setMontant($projet->getMontant()+$formulaire->getMontantform());
        $em->remove($formulaire);
        $em->flush();
        return $this->redirectToRoute('projet_afficheformulaire');

    }



}
