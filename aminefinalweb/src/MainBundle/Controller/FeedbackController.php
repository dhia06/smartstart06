<?php

namespace MainBundle\Controller;

use MainBundle\Entity\Feedback;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Component\HttpFoundation\Request;

/**
 * Feedback controller.
 *
 */
class FeedbackController extends Controller
{
    /**
     * Lists all feedback entities.
     *
     */
    public function indexAction()
    {
        $em = $this->getDoctrine()->getManager();

        $feedbacks = $em->getRepository('MainBundle:Feedback')->findAll();

        return $this->render('feedback/index.html.twig', array(
            'feedbacks' => $feedbacks,
        ));
    }

    /**
     * Creates a new feedback entity.
     *
     */
    public function newAction(Request $request)
    {
        $feedback = new Feedback();
        $form = $this->createForm('MainBundle\Form\FeedbackType', $feedback);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $em = $this->getDoctrine()->getManager();
            $em->persist($feedback);
            $em->flush();

            return $this->redirectToRoute('feedback_show', array('id7' => $feedback->getId7()));
        }

        return $this->render('feedback/new.html.twig', array(
            'feedback' => $feedback,
            'form' => $form->createView(),
        ));
    }

    /**
     * Finds and displays a feedback entity.
     *
     */
    public function showAction(Feedback $feedback)
    {
        $deleteForm = $this->createDeleteForm($feedback);

        return $this->render('feedback/show.html.twig', array(
            'feedback' => $feedback,
            'delete_form' => $deleteForm->createView(),
        ));
    }
    /**
     * Displays a form to edit an existing feedback entity.
     *
     */
    public function editAction(Request $request, Feedback $feedback)
    {
        $deleteForm = $this->createDeleteForm($feedback);
        $editForm = $this->createForm('MainBundle\Form\FeedbackType', $feedback);
        $editForm->handleRequest($request);

        if ($editForm->isSubmitted() && $editForm->isValid()) {
            $this->getDoctrine()->getManager()->flush();

            return $this->redirectToRoute('feedback_edit', array('id7' => $feedback->getId7()));
        }

        return $this->render('feedback/edit.html.twig', array(
            'feedback' => $feedback,
            'edit_form' => $editForm->createView(),
            'delete_form' => $deleteForm->createView(),
        ));
    }

    /**
     * Deletes a feedback entity.
     *
     */
    public function deleteAction(Request $request, Feedback $feedback)
    {
        $form = $this->createDeleteForm($feedback);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $em = $this->getDoctrine()->getManager();
            $em->remove($feedback);
            $em->flush();
        }

        return $this->redirectToRoute('feedback_index');
    }

    /**
     * Creates a form to delete a feedback entity.
     *
     * @param Feedback $feedback The feedback entity
     *
     * @return \Symfony\Component\Form\Form The form
     */
    private function createDeleteForm(Feedback $feedback)
    {
        return $this->createFormBuilder()
            ->setAction($this->generateUrl('feedback_delete', array('id7' => $feedback->getId7())))
            ->setMethod('DELETE')
            ->getForm()
        ;
    }
    public function repondreAction()
    {
        return $this->render('feedback/repondre.html.twig');
    }
}
