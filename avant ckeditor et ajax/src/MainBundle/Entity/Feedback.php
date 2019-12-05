<?php

namespace MainBundle\Entity;

use Doctrine\ORM\Mapping as ORM;
use Symfony\Component\Validator\Constraints as Assert;


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
     * @ORM\Column(name="contenu7", type="string", length=50, nullable=false)
     */
    private $contenu7;

    /**
     * @var string
     *@Assert\NotBlank()
     *@Assert\Email()
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



    /**
     * Get id7
     *
     * @return integer
     */
    public function getId7()
    {
        return $this->id7;
    }

    /**
     * Set objet7
     *
     * @param string $objet7
     *
     * @return Feedback
     */
    public function setObjet7($objet7)
    {
        $this->objet7 = $objet7;

        return $this;
    }

    /**
     * Get objet7
     *
     * @return string
     */
    public function getObjet7()
    {
        return $this->objet7;
    }

    /**
     * Set contenu7
     *
     * @param string $contenu7
     *
     * @return Feedback
     */
    public function setContenu7($contenu7)
    {
        $this->contenu7 = $contenu7;

        return $this;
    }

    /**
     * Get contenu7
     *
     * @return string
     */
    public function getContenu7()
    {
        return $this->contenu7;
    }

    /**
     * Set mail7
     *
     * @param string $mail7
     *
     * @return Feedback
     */
    public function setMail7($mail7)
    {
        $this->mail7 = $mail7;

        return $this;
    }

    /**
     * Get mail7
     *
     * @return string
     */
    public function getMail7()
    {
        return $this->mail7;
    }

    /**
     * Set iduser7
     *
     * @param \MainBundle\Entity\FosUser $iduser7
     *
     * @return Feedback
     */
    public function setIduser7(\MainBundle\Entity\FosUser $iduser7 = null)
    {
        $this->iduser7 = $iduser7;

        return $this;
    }

    /**
     * Get iduser7
     *
     * @return \MainBundle\Entity\FosUser
     */
    public function getIduser7()
    {
        return $this->iduser7;
    }
}
