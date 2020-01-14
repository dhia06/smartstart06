<?php

namespace ActualiteBundle\Entity;

use Doctrine\ORM\Mapping as ORM;
use Symfony\Component\Validator\Constraints as Assert;

/**
 * Actualite
 *
 * @ORM\Table(name="actualite")
 * @ORM\Entity(repositoryClass="ActualiteBundle\Repository\ActualiteRepository")
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
     * @ORM\Column(name="date", type="datetime", nullable=false)
     */
    private $date;

    /**
     * @var string
     *
     * @ORM\Column(name="description", type="text", length=65535, nullable=false)
     */
    private $description;
    /**
     * @Assert\File(maxSize="500k")

     */
    public $file ;

    /**
     * @var string
     *
     * @ORM\Column(name="img", type="string", length=200, nullable=false)
     */
    private $img;

    /**
     * @var integer
     *
     * @ORM\Column(name="nb_Click", type="integer", options={"default":0})
     */
    private $nbClick;

    /**
     * @var boolean
     *
     * @ORM\Column(name="etat", type="boolean", nullable=false)
     */
    private $etat;

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
     * @return Actualite
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
     * Set date
     *
     * @param \DateTime $date
     *
     * @return Actualite
     */
    public function setDate($date)
    {
        $this->date = $date;

        return $this;
    }

    /**
     * Get date
     *
     * @return \DateTime
     */
    public function getDate()
    {
        return $this->date;
    }

    /**
     * Set description
     *
     * @param string $description
     *
     * @return Actualite
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
     * Set img
     *
     * @param string $img
     *
     * @return Actualite
     */
    public function setImg($img)
    {
        $this->img = $img;

        return $this;
    }

    /**
     * Get img
     *
     * @return string
     */
    public function getImg()
    {
        return $this->img;
    }
    public function getWebPath(){
        return null=== $this->img ? null : $this->getUploadDir.'/'.$this->img ;
    }

    protected function getUlpoadRootDir(){
        return __DIR__.'/../../../../web/'.$this->getUploadDir();
    }
    protected function getUploadDir(){
        return 'img' ;
    }

    /**
     *
     */
    public function uploadProfilePicture(){
        $this->file->move($this->getUploadDir(),$this->file->getClientOriginalName());
        $this->img=$this->file->getClientOriginalName();
        $this->file=null;
    }

    /**
     * Set nbClick
     *
     * @param integer $nbClick
     *
     * @return Actualite
     */
    public function setNbClick($nbClick)
    {
        $this->nbClick = $nbClick;

        return $this;
    }

    /**
     * Get nbClick
     *
     * @return integer
     */
    public function getNbClick()
    {
        return $this->nbClick;
    }

    /**
     * Set etat
     *
     * @param boolean $etat
     *
     * @return Actualite
     */
    public function setEtat($etat)
    {
        $this->etat = $etat;

        return $this;
    }

    /**
     * Get etat
     *
     * @return boolean
     */
    public function getEtat()
    {
        return $this->etat;
    }

    /**
     * Set idCategorie
     *
     * @param \ActualiteBundle\Entity\Categorie $idCategorie
     *
     * @return Actualite
     */
    public function setIdCategorie(\ActualiteBundle\Entity\Categorie $idCategorie = null)
    {
        $this->idCategorie = $idCategorie;

        return $this;
    }

    /**
     * Get idCategorie
     *
     * @return \ActualiteBundle\Entity\Categorie
     */
    public function getIdCategorie()
    {
        return $this->idCategorie;
    }
}
