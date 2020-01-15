<?php

namespace ActualiteBundle\Form;

use ActualiteBundle\Entity\Categorie;
use ActualiteBundle\Entity\Genre;
use Doctrine\DBAL\Types\Type;
use Symfony\Bridge\Doctrine\Form\Type\EntityType;
use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\Extension\Core\Type\FileType;
use Symfony\Component\Form\Extension\Core\Type\SubmitType;
use Symfony\Component\Form\Extension\Core\Type\TextareaType;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\OptionsResolver\OptionsResolver;
use Twig\Template;

class ActualiteType extends AbstractType
{
    /**
     * {@inheritdoc}
     */
    public function buildForm(FormBuilderInterface $builder, array $options)
    {
        $builder->add('titre')
            ->add('date')
            ->add('description' , TextareaType::class)
            ->add('file' , FileType::class)
          //  ->add('nbClick')
          //  ->add('etat')
           ->add('idCategorie',EntityType::class, array(
           'class'=>Genre::class,
           'choice_label'=>'libelle'))
           //'multiple'=>false))
        //   ->add('user')
            ->add('Ajouter',SubmitType::class);
    }/**
     * {@inheritdoc}
     */
    public function configureOptions(OptionsResolver $resolver)
    {
        $resolver->setDefaults(array(
            'data_class' => 'ActualiteBundle\Entity\Actualite'
        ));
    }

    /**
     * {@inheritdoc}
     */
    public function getBlockPrefix()
    {
        return 'actualitebundle_actualite';
    }


}
