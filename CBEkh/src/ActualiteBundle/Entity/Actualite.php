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
     * @ORM\Column(name="date", type="date", nullable=false)
     */
    private $date;

    /**
     * @var string
     *
     * @ORM\Column(name="description", type="text", length=65535, nullable=false)
     */
    private $description;

    /**
     * @return int
     */
    public function getNbClick()
    {
        return $this->nbClick;
    }

    /**
     * @param int $nbClick
     */
    public function setNbClick($nbClick)
    {
        $this->nbClick = $nbClick;
    }

    /**
     * @return bool
     */
    public function isEtat()
    {
        return $this->etat;
    }

    /**
     * @param bool $etat
     */
    public function setEtat($etat)
    {
        $this->etat = $etat;
    }

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
     * @return \DateTime
     */
    public function getDate()
    {
        return $this->date;
    }

    /**
     * @param \DateTime $date
     */
    public function setDate($date)
    {
        $this->date = $date;
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
     * @return string
     */
    public function getImg()
    {
        return $this->img;
    }

    /**
     * @param string $img
     */
    public function setImg($img)
    {
        $this->img = $img;
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
     * @return \Genre
     */
    public function getIdCategorie()
    {
        return $this->idCategorie;
    }

    /**
     * @param \Genre $idCategorie
     */
    public function setIdCategorie($idCategorie)
    {
        $this->idCategorie = $idCategorie;
    }

    /**
     * @var \Genre
     *
     * @ORM\ManyToOne(targetEntity="Genre")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="id_categorie", referencedColumnName="id")
     * })
     */
    private $idCategorie;
}