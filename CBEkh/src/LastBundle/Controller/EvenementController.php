<?php

namespace LastBundle\Controller;

use LastBundle\Entity\Evenement;
use LastBundle\Form\EvenementType;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Component\HttpFoundation\Request;
//use Doctrine\Common\Persistence\PersistentObject;
//use http\Env\Response;
use Doctrine\Common\Persistence\PersistentObject;
use Symfony\Component\HttpFoundation\Response;


/**
 * Evenement controller.
 *
 */
class EvenementController extends Controller
{
    /**
     * Lists all evenement entities.
     *
     */
    public function indexAction(Request $request)
    {
        $em = $this->getDoctrine()->getManager();

        $evenements = $em->getRepository('LastBundle:Evenement')->findAll();

       /* return $this->render('evenement/index.html.twig', array(
            'evenements' => $evenements,
        ));
        */


        $paginator  = $this->get('knp_paginator');

        $pagination = $paginator->paginate($evenements,
            $request->query->get('page',1),
            $request->query->get('limit',3)

        );

        return $this->render('evenement/index.html.twig', array(
            'evenements' => $pagination ,));
    }

    /**
     * Creates a new evenement entity.
     *
     */
    public function newAction(Request $request)
    {
        $evenement = new Evenement();
        $form = $this->createForm(EvenementType::class, $evenement);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            //upload Image
           $evenement->uploadProfilePicture();
           // $evenement->setDateEvent(new \DateTime());
            $em = $this->getDoctrine()->getManager();
            $em->persist($evenement);
            $em->flush();

            return $this->redirectToRoute('evenement_index', array('id' => $evenement->getId()));
        }

        return $this->render('evenement/new.html.twig', array(
            'evenement' => $evenement,
            'form' => $form->createView(),
        ));
    }


    /**
     * Finds and displays a evenement entity.
     *
     */
    public function showAction(Evenement $evenement)
    {
        $deleteForm = $this->createDeleteForm($evenement);

        return $this->render('evenement/show.html.twig', array(
            'evenement' => $evenement,
            'delete_form' => $deleteForm->createView(),
        ));
    }

    /**
     * Displays a form to edit an existing evenement entity.
     *
     */
    public function editAction(Request $request, Evenement $evenement)
    {
        $deleteForm = $this->createDeleteForm($evenement);
        $editForm = $this->createForm('LastBundle\Form\EvenementType', $evenement);
        $editForm->handleRequest($request);

        if ($editForm->isSubmitted() && $editForm->isValid()) {
            $this->getDoctrine()->getManager()->flush();

            return $this->redirectToRoute('evenement_index', array('id' => $evenement->getId()));
        }

        return $this->render('evenement/edit.html.twig', array(
            'evenement' => $evenement,
            'form' => $editForm->createView(),
            'delete_form' => $deleteForm->createView(),
        ));
    }

    /**
     * Deletes a evenement entity.
     *
     */
    public function deleteAction(Request $request, Evenement $evenement)
    {
        $form = $this->createDeleteForm($evenement);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $em = $this->getDoctrine()->getManager();
            $em->remove($evenement);
            $em->flush();
        }

        return $this->redirectToRoute('evenement_index');
    }

    /**
     * Creates a form to delete a evenement entity.
     *
     * @param Evenement $evenement The evenement entity
     *
     * @return \Symfony\Component\Form\Form The form
     */
    private function createDeleteForm(Evenement $evenement)
    {
        return $this->createFormBuilder()
            ->setAction($this->generateUrl('evenement_delete', array('id' => $evenement->getId())))
            ->setMethod('DELETE')
            ->getForm()
        ;
    }
    public function calendrierAction()
    {$events = $this->getDoctrine()->getRepository(Evenement::class)->findAll();
        return $this->render('evenement/calendrier.html.twig', array(
            'events' => $events));
    }
    public function pdfAction(Evenement $evenement)

    {

        $snappy=$this->get('knp_snappy.pdf');

        $html= $this->renderView(
            'evenement/pdf.html.twig',
            array(
                'event' => $evenement
            ));


      $filename ="downloadpdf";
        return new Response($snappy->getOutputFromHtml($html),200,array(
            'Content-Type'=>"application/pdf",
            'Content-Disposition'=>'attachment ; filename="'.$filename.'.pdf"'
        ));

    }
}
