<?php

namespace MainBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Formulaire
 *
 * @ORM\Table(name="formulaire", indexes={@ORM\Index(name="idprojet", columns={"idprojet"})})
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
     * @return int
     */
    public function getIdfor()
    {
        return $this->idfor;
    }

    /**
     * @param int $idfor
     */
    public function setIdfor($idfor)
    {
        $this->idfor = $idfor;
    }

    /**
     * @return string
     */
    public function getNom()
    {
        return $this->nom;
    }

    /**
     * @param string $nom
     */
    public function setNom($nom)
    {
        $this->nom = $nom;
    }

    /**
     * @return string
     */
    public function getPrenom()
    {
        return $this->prenom;
    }

    /**
     * @param string $prenom
     */
    public function setPrenom($prenom)
    {
        $this->prenom = $prenom;
    }

    /**
     * @return int
     */
    public function getTel()
    {
        return $this->tel;
    }

    /**
     * @param int $tel
     */
    public function setTel($tel)
    {
        $this->tel = $tel;
    }

    /**
     * @return string
     */
    public function getMail()
    {
        return $this->mail;
    }

    /**
     * @param string $mail
     */
    public function setMail($mail)
    {
        $this->mail = $mail;
    }

    /**
     * @return string
     */
    public function getNomduprojet()
    {
        return $this->nomduprojet;
    }

    /**
     * @param string $nomduprojet
     */
    public function setNomduprojet($nomduprojet)
    {
        $this->nomduprojet = $nomduprojet;
    }

    /**
     * @return int
     */
    public function getMontantform()
    {
        return $this->montantform;
    }

    /**
     * @param int $montantform
     */
    public function setMontantform($montantform)
    {
        $this->montantform = $montantform;
    }

    /**
     * @return \Projet
     */
    public function getIdprojet()
    {
        return $this->idprojet;
    }

    /**
     * @param \Projet $idprojet
     */
    public function setIdprojet($idprojet)
    {
        $this->idprojet = $idprojet;
    }

    /**
     * @var string
     *
     * @ORM\Column(name="Nom", type="string", length=255, nullable=false)
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
     * @ORM\Column(name="MontantForm", type="integer", nullable=false)
     */
    private $montantform;

    /**
     * @var \Projet
     *
     * @ORM\ManyToOne(targetEntity="Projet")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="idprojet", referencedColumnName="id")
     * })
     */
    private $idprojet;


}

