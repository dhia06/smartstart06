<?php

namespace LastBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Actualite
 *
 * @ORM\Table(name="actualite", indexes={@ORM\Index(name="id_categorie", columns={"id_categorie"})})
 * @ORM\Entity
 */
class Actualite
{
    /**
     * @var integer
     *
     * @ORM\Column(name="id", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $id;

    /**
     * @var string
     *
     * @ORM\Column(name="titre", type="string", length=30, nullable=false)
     */
    private $titre;

    /**
     * @var \DateTime
     *
     * @ORM\Column(name="date", type="date", nullable=false)
     */
    private $date;

    /**
     * @var string
     *
     * @ORM\Column(name="description", type="string", length=255, nullable=false)
     */
    private $description;

    /**
     * @var string
     *
     * @ORM\Column(name="img", type="string", length=200, nullable=false)
     */
    private $img;

    /**
     * @var \Categorie
     *
     * @ORM\ManyToOne(targetEntity="Categorie")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="id_categorie", referencedColumnName="id")
     * })
     */
    private $idCategorie;


}

