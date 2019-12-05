<?php

namespace MainBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Formulaire
 *
 * @ORM\Table(name="formulaire")
 * @ORM\Entity
 */
class Formulaire
{
    /**
     * @var integer
     *
     * @ORM\Column(name="idFor", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idfor;

    /**
     * @var string
     *
     * @ORM\Column(name="nom", type="string", length=255, nullable=false)
     */
    private $nom;

    /**
     * @var string
     *
     * @ORM\Column(name="prenom", type="string", length=255, nullable=false)
     */
    private $prenom;

    /**
     * @var integer
     *
     * @ORM\Column(name="tel", type="integer", nullable=false)
     */
    private $tel;

    /**
     * @var string
     *
     * @ORM\Column(name="mail", type="string", length=255, nullable=false)
     */
    private $mail;

    /**
     * @var string
     *
     * @ORM\Column(name="nomduprojet", type="string", length=255, nullable=false)
     */
    private $nomduprojet;

    /**
     * @var integer
     *
     * @ORM\Column(name="montantForm", type="integer", nullable=false)
     */
    private $montantform;


}

