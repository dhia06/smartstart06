<?php

namespace MainBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Feedback
 *
 * @ORM\Table(name="feedback", indexes={@ORM\Index(name="iduser7", columns={"iduser7"})})
 * @ORM\Entity
 */
class Feedback
{
    /**
     * @var integer
     *
     * @ORM\Column(name="id7", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $id7;

    /**
     * @var string
     *
     * @ORM\Column(name="objet7", type="string", length=50, nullable=false)
     */
    private $objet7;

    /**
     * @var string
     *
     * @ORM\Column(name="contenu7", type="string", length=255, nullable=false)
     */
    private $contenu7;

    /**
     * @return int
     */
    public function getId7()
    {
        return $this->id7;
    }

    /**
     * @param int $id7
     */
    public function setId7($id7)
    {
        $this->id7 = $id7;
    }

    /**
     * @return string
     */
    public function getObjet7()
    {
        return $this->objet7;
    }

    /**
     * @param string $objet7
     */
    public function setObjet7($objet7)
    {
        $this->objet7 = $objet7;
    }

    /**
     * @return string
     */
    public function getContenu7()
    {
        return $this->contenu7;
    }

    /**
     * @param string $contenu7
     */
    public function setContenu7($contenu7)
    {
        $this->contenu7 = $contenu7;
    }

    /**
     * @return string
     */
    public function getMail7()
    {
        return $this->mail7;
    }

    /**
     * @param string $mail7
     */
    public function setMail7($mail7)
    {
        $this->mail7 = $mail7;
    }

    /**
     * @return \FosUser
     */
    public function getIduser7()
    {
        return $this->iduser7;
    }

    /**
     * @param \FosUser $iduser7
     */
    public function setIduser7($iduser7)
    {
        $this->iduser7 = $iduser7;
    }

    /**
     * @var string
     *
     * @ORM\Column(name="mail7", type="string", length=50, nullable=false)
     */
    private $mail7;

    /**
     * @var \FosUser
     *
     * @ORM\ManyToOne(targetEntity="FosUser")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="iduser7", referencedColumnName="id")
     * })
     */
    private $iduser7;


}

