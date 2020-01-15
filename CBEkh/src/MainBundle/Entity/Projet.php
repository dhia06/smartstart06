<?php

namespace MainBundle\Entity;
use Symfony\Component\Validator\Constraints as Assert;
use Doctrine\ORM\Mapping as ORM;

/**
 * Projet
 *
 * @ORM\Table(name="projet")
 * @ORM\Entity
 */
class Projet
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
     * @ORM\Column(name="titre", type="string", length=20, nullable=false)
     */
    private $titre;

    /**
     * @var string
     *
     * @ORM\Column(name="objectif", type="string", length=20, nullable=false)
     */
    private $objectif;

    /**
     * @var \DateTime
     *
     * @ORM\Column(name="Date_Deb", type="date", nullable=false)
     * @Assert\GreaterThanOrEqual("Today")
     */
    private $dateDeb;

    /**
     * @var \DateTime
     *
     * @ORM\Column(name="Date_Fin", type="date", nullable=false)
     * @Assert\GreaterThanOrEqual(  "+ 1 month")
     */
    private $dateFin;

    /**
     * @var string
     *
     * @ORM\Column(name="description", type="string", length=200, nullable=false)
     */
    private $description;

    /**
     * @var integer
     *
     * @ORM\Column(name="Montant", type="integer", nullable=false)
     * @Assert\Range( min=200 , max=2000)
     */
    private $montant;

    /**
     * @var string
     *
     * @ORM\Column(name="ImageP", type="string", length=255, nullable=false)
     * @Assert\File(mimeTypes={ "image/jpeg" ,  "image/png"})
     */
    private $imagep;

    /**
     * @return int
     */
    public function getId()
    {
        return $this->id;
    }

    /**
     * @param int $id
     */
    public function setId($id)
    {
        $this->id = $id;
    }

    /**
     * @return string
     */
    public function getTitre()
    {
        return $this->titre;
    }

    /**
     * @param string $titre
     */
    public function setTitre($titre)
    {
        $this->titre = $titre;
    }

    /**
     * @return string
     */
    public function getObjectif()
    {
        return $this->objectif;
    }

    /**
     * @param string $objectif
     */
    public function setObjectif($objectif)
    {
        $this->objectif = $objectif;
    }

    /**
     * @return \DateTime
     */
    public function getDateDeb()
    {
        return $this->dateDeb;
    }

    /**
     * @param \DateTime $dateDeb
     */
    public function setDateDeb($dateDeb)
    {
        $this->dateDeb = $dateDeb;
    }

    /**
     * @return \DateTime
     */
    public function getDateFin()
    {
        return $this->dateFin;
    }

    /**
     * @param \DateTime $dateFin
     */
    public function setDateFin($dateFin)
    {
        $this->dateFin = $dateFin;
    }

    /**
     * @return string
     */
    public function getDescription()
    {
        return $this->description;
    }

    /**
     * @param string $description
     */
    public function setDescription($description)
    {
        $this->description = $description;
    }

    /**
     * @return int
     */
    public function getMontant()
    {
        return $this->montant;
    }

    /**
     * @param int $montant
     */
    public function setMontant($montant)
    {
        $this->montant = $montant;
    }

    /**
     * @return string
     */
    public function getImagep()
    {
        return $this->imagep;
    }

    /**
     * @param string $imagep
     */
    public function setImagep($imagep)
    {
        $this->imagep = $imagep;
    }




}

