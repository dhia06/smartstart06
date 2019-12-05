<?php

namespace MainBundle\Entity;

use Doctrine\ORM\Mapping as ORM;
use Symfony\Component\Validator\Constraints as Assert;


/**
 * Reclamation
 *
 * @ORM\Table(name="reclamation", indexes={@ORM\Index(name="iduser", columns={"iduser"})})
 * @ORM\Entity(repositoryClass="MainBundle\Repository\ReclamationRepository")
 */
class Reclamation
{
    /**
     * @var integer
     *
     * @ORM\Column(name="id11", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $id11;

    /**
     * @var string
     *
     * @ORM\Column(name="sujet11", type="string", length=30, nullable=false)
     */
    private $sujet11;

    /**
     * @var string
     *
     * @ORM\Column(name="text11", type="string", length=30, nullable=false)
     */
    private $text11;

    /**
     * @var string
     * @Assert\Length(
     *     min="8",
     *     max="8")
     * *@Assert\NotBlank()
     * *@Assert\Regex(
     *   pattern="/[0-9]{8}/"
     * )
     * @ORM\Column(name="phone11", type="string", nullable=false)
     */
    private $phone11;

    /**
     * @var \FosUser
     *
     * @ORM\ManyToOne(targetEntity="FosUser")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="iduser", referencedColumnName="id")
     * })
     */
    private $iduser;



    /**
     * Get id11
     *
     * @return integer
     */
    public function getId11()
    {
        return $this->id11;
    }

    /**
     * Set sujet11
     *
     * @param string $sujet11
     *
     * @return Reclamation
     */
    public function setSujet11($sujet11)
    {
        $this->sujet11 = $sujet11;

        return $this;
    }

    /**
     * Get sujet11
     *
     * @return string
     */
    public function getSujet11()
    {
        return $this->sujet11;
    }

    /**
     * Set text11
     *
     * @param string $text11
     *
     * @return Reclamation
     */
    public function setText11($text11)
    {
        $this->text11 = $text11;

        return $this;
    }

    /**
     * Get text11
     *
     * @return string
     */
    public function getText11()
    {
        return $this->text11;
    }

    /**
     * Set phone11
     *
     * @param string $phone11
     *
     * @return Reclamation
     */
    public function setPhone11($phone11)
    {
        $this->phone11 = $phone11;

        return $this;
    }

    /**
     * Get phone11
     *
     * @return string
     */
    public function getPhone11()
    {
        return $this->phone11;
    }

    /**
     * Set iduser
     *
     * @param \MainBundle\Entity\FosUser $iduser
     *
     * @return Reclamation
     */
    public function setIduser(\MainBundle\Entity\FosUser $iduser = null)
    {
        $this->iduser = $iduser;

        return $this;
    }

    /**
     * Get iduser
     *
     * @return \MainBundle\Entity\FosUser
     */
    public function getIduser()
    {
        return $this->iduser;
    }
    public function __toString()
    {
        return (string) $this->iduser=getId();
    }
}
