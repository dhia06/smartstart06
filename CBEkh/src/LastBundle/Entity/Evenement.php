<?php

namespace LastBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Evenement
 *
 * @ORM\Table(name="evenement", indexes={@ORM\Index(name="id_categorie", columns={"id_categorie"})})
 * @ORM\Entity
 */
class Evenement
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
     * @ORM\Column(name="titre", type="string", length=255, nullable=false)
     */
    private $titre;

    /**
     * @var string
     *
     * @ORM\Column(name="lieu", type="string", length=255, nullable=false)
     */
    private $lieu;

    /**
     * @var string
     *
     * @ORM\Column(name="description", type="string", length=255, nullable=false)
     */
    private $description;

    /**
     * @var \DateTime
     *
     * @ORM\Column(name="date_event", type="date", nullable=false)
     */
    private $dateEvent;

    /**
     * @var integer
     *
     * @ORM\Column(name="nbplace", type="integer", nullable=false)
     */
    private $nbplace;

    /**
     * @var string
     *
     * @ORM\Column(name="nom_image", type="string", length=255, nullable=false)
     */
    private $nomImage;

    /**
     * @var \Categorie
     *
     * @ORM\ManyToOne(targetEntity="Categorie")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="id_categorie", referencedColumnName="id")
     * })
     */
    private $idCategorie;



    /**
     * Get id
     *
     * @return integer
     */
    public function getId()
    {
        return $this->id;
    }

    /**
     * Set titre
     *
     * @param string $titre
     *
     * @return Evenement
     */
    public function setTitre($titre)
    {
        $this->titre = $titre;

        return $this;
    }

    /**
     * Get titre
     *
     * @return string
     */
    public function getTitre()
    {
        return $this->titre;
    }

    /**
     * Set lieu
     *
     * @param string $lieu
     *
     * @return Evenement
     */
    public function setLieu($lieu)
    {
        $this->lieu = $lieu;

        return $this;
    }

    /**
     * Get lieu
     *
     * @return string
     */
    public function getLieu()
    {
        return $this->lieu;
    }

    /**
     * Set description
     *
     * @param string $description
     *
     * @return Evenement
     */
    public function setDescription($description)
    {
        $this->description = $description;

        return $this;
    }

    /**
     * Get description
     *
     * @return string
     */
    public function getDescription()
    {
        return $this->description;
    }

    /**
     * Set dateEvent
     *
     * @param \DateTime $dateEvent
     *
     * @return Evenement
     */
    public function setDateEvent($dateEvent)
    {
        $this->dateEvent = $dateEvent;

        return $this;
    }

    /**
     * Get dateEvent
     *
     * @return \DateTime
     */
    public function getDateEvent()
    {
        return $this->dateEvent;
    }

    /**
     * Set nbplace
     *
     * @param integer $nbplace
     *
     * @return Evenement
     */
    public function setNbplace($nbplace)
    {
        $this->nbplace = $nbplace;

        return $this;
    }

    /**
     * Get nbplace
     *
     * @return integer
     */
    public function getNbplace()
    {
        return $this->nbplace;
    }

    /**
     * Set nomImage
     *
     * @param string $nomImage
     *
     * @return Evenement
     */
    public function setNomImage($nomImage)
    {
        $this->nomImage = $nomImage;

        return $this;
    }

    /**
     * Get nomImage
     *
     * @return string
     */
    public function getNomImage()
    {
        return $this->nomImage;
    }

    /**
     * Set idCategorie
     *
     * @param \LastBundle\Entity\Categorie $idCategorie
     *
     * @return Evenement
     */
    public function setIdCategorie(\LastBundle\Entity\Categorie $idCategorie = null)
    {
        $this->idCategorie = $idCategorie;

        return $this;
    }

    /**
     * Get idCategorie
     *
     * @return \LastBundle\Entity\Categorie
     */
    public function getIdCategorie()
    {
        return $this->idCategorie;
    }
}
