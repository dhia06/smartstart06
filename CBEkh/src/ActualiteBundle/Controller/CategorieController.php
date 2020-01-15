<?php

namespace ActualiteBundle\Controller;


use ActualiteBundle\Entity\Genre;

use ActualiteBundle\Form\GenreType;
use Doctrine\DBAL\Types\Type;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Sensio\Bundle\FrameworkExtraBundle\Configuration\Method;
use Sensio\Bundle\FrameworkExtraBundle\Configuration\Route;use Symfony\Component\HttpFoundation\Request;

/**
 * Categorie controller.
 *
 * @Route("categorie")
 */
class CategorieController extends Controller
{
    /**
     * Lists all categorie entities.
     *
     * @Route("/", name="categorie_index")
     * @Method("GET")
     */
    public function indexAction()
    {
        $em = $this->getDoctrine()->getManager();

        $categories = $em->getRepository('ActualiteBundle:Categorie')->findAll();

        return $this->render('categorie/index.html.twig', array(
            'categories' => $categories,
        ));
    }

    /**
     * Creates a new categorie entity.
     *
     * @Route("/new", name="categorie_new")
     * @Method({"GET", "POST"})
     */
    public function newAction(Request $request)
    {
        $categorie = new Genre();
        $form = $this->createForm(GenreType::class,$categorie);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $em = $this->getDoctrine()->getManager();
            $em->persist($categorie);
            $em->flush();

            return $this->redirectToRoute('categorie_affiche');
        }

        return $this->render('@Actualite/Categorie/new.html.twig', array(

            'form' => $form->createView(),
        ));
    }

    /**
     * Finds and displays a categorie entity.
     *
     * @Route("/{id}", name="categorie_show")
     * @Method("GET")
     */
    public function showAction()
    {
        $categorie = $this->getDoctrine()->getRepository(Genre::class)->findAll();
        return $this->render("@Actualite/Categorie/show.html.twig", array('categorie'=>$categorie));

    }

    /**
     * Displays a form to edit an existing categorie entity.
     *
     * @Route("/{id}/edit", name="categorie_edit")
     * @Method({"GET", "POST"})
     */
    public function editAction(Request $request, $id)
    {
        $categorie = $this->getDoctrine()->getRepository(Genre::class)->find($id);

        $form = $this->createForm(GenreType::class, $categorie);
        $form->handleRequest($request);
        if ($form->isValid()) {


            $em = $this->getDoctrine()->getManager();
            $em->flush();
            return $this->redirectToRoute("categorie_affiche", array('id' => $id));
        }
        return $this->render("@Actualite/Categorie/edit.html.twig", array('edit_form' => $form->createView()));

    }

    /**
     * Deletes a categorie entity.
     *
     * @Route("/{id}", name="categorie_delete")
     * @Method("DELETE")
     */
    public function deleteAction(Request $request, Genre $categorie)
    {
        $form = $this->createDeleteForm($categorie);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $em = $this->getDoctrine()->getManager();
            $em->remove($categorie);
            $em->flush();
        }

        return $this->redirectToRoute('categorie_affiche');
    }

    /**
     * Creates a form to delete a categorie entity.
     *
     * @param Categorie $categorie The categorie entity
     *
     * @return \Symfony\Component\Form\Form The form
     */
    private function createDeleteForm(Genre $categorie)
    {
        return $this->createFormBuilder()
            ->setAction($this->generateUrl('categorie_supprimer', array('id' => $categorie->getId())))
            ->setMethod('DELETE')
            ->getForm()
        ;
    }
}
