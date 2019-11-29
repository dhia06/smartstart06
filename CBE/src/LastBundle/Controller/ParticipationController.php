<?php

namespace LastBundle\Controller;

use LastBundle\Entity\Participation;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Component\HttpFoundation\Request;
use LastBundle\Entity\Evenement;

/**
 * Participation controller.
 *
 */
class ParticipationController extends Controller
{
    /**
     * Lists all participation entities.
     *
     */
    public function indexAction()
    {
        $em = $this->getDoctrine()->getManager();

        $participations = $em->getRepository('LastBundle:Participation')->findAll();

        return $this->render('participation/index.html.twig', array(
            'participations' => $participations,
        ));
    }

    /**
     * Creates a new participation entity.
     *
     */
/*public function newAction(Request $request)
    {
        $participation = new Participation();
        $form = $this->createForm('LastBundle\Form\ParticipationType', $participation);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $em = $this->getDoctrine()->getManager();
            $em->persist($participation);
            $em->flush();

            return $this->redirectToRoute('participation_show', array('paticipantId' => $participation->getPaticipantid()));
        }

        return $this->render('participation/new.html.twig', array(
            'participation' => $participation,
            'form' => $form->createView(),
        ));
    }*/

    /**
     * Finds and displays a participation entity.
     *
     */
   /* public function showAction(Participation $participation)
    {
        $deleteForm = $this->createDeleteForm($participation);

        return $this->render('participation/show.html.twig', array(
            'participation' => $participation,
            'delete_form' => $deleteForm->createView(),
        ));
    }*/

    /**
     * Displays a form to edit an existing participation entity.
     *
     */
 /*   public function editAction(Request $request, Participation $participation)
    {
        $deleteForm = $this->createDeleteForm($participation);
        $editForm = $this->createForm('LastBundle\Form\ParticipationType', $participation);
        $editForm->handleRequest($request);

        if ($editForm->isSubmitted() && $editForm->isValid()) {
            $this->getDoctrine()->getManager()->flush();

            return $this->redirectToRoute('participation_edit', array('paticipantId' => $participation->getPaticipantid()));
        }

        return $this->render('participation/edit.html.twig', array(
            'participation' => $participation,
            'edit_form' => $editForm->createView(),
            'delete_form' => $deleteForm->createView(),
        ));
    }*/

    /**
     * Deletes a participation entity.
     *
     */
  /*  public function deleteAction(Request $request, Participation $participation)
    {
        $form = $this->createDeleteForm($participation);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $em = $this->getDoctrine()->getManager();
            $em->remove($participation);
            $em->flush();
        }

        return $this->redirectToRoute('participation_index');
    }*/

    /**
     * Creates a form to delete a participation entity.
     *
     * @param Participation $participation The participation entity
     *
     * @return \Symfony\Component\Form\Form The form
     */
  /*  private function createDeleteForm(Participation $participation)
    {
        return $this->createFormBuilder()
            ->setAction($this->generateUrl('participation_delete', array('paticipantId' => $participation->getPaticipantid())))
            ->setMethod('DELETE')
            ->getForm()
        ;
    }*/
    public function ajoutresAction( $idEvent)
    {
        $em = $this->getDoctrine()->getManager();
        $event=$em->getRepository('LastBundle:Evenement')->find($idEvent);
        if( $event->getNbplace()> 0) {
            $event->setNbplace($event->getNbplace() - 1);
            $em->persist($event);
            $em->flush();
            return $this->redirectToRoute('evenement_show', array('id' => $event->getId()));
        }

else
{
            return $this->render('participation/msg.html.twig');
}

    }

}
