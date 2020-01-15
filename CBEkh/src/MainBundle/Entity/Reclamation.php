<?php

namespace MainBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Reclamation
 *
 * @ORM\Table(name="reclamation", indexes={@ORM\Index(name="iduser", columns={"iduser"})})
 * @ORM\Entity
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
     *
     * @ORM\Column(name="phone11", type="string", length=30, nullable=false)
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
     * @return int
     */
    public function getId11()
    {
        return $this->id11;
    }

    /**
     * @param int $id11
     */
    public function setId11($id11)
    {
        $this->id11 = $id11;
    }

    /**
     * @return string
     */
    public function getSujet11()
    {
        return $this->sujet11;
    }

    /**
     * @param string $sujet11
     */
    public function setSujet11($sujet11)
    {
        $this->sujet11 = $sujet11;
    }

    /**
     * @return string
     */
    public function getText11()
    {
        return $this->text11;
    }

    /**
     * @param string $text11
     */
    public function setText11($text11)
    {
        $this->text11 = $text11;
    }

    /**
     * @return string
     */
    public function getPhone11()
    {
        return $this->phone11;
    }

    /**
     * @param string $phone11
     */
    public function setPhone11($phone11)
    {
        $this->phone11 = $phone11;
    }

    /**
     * @return \FosUser
     */
    public function getIduser()
    {
        return $this->iduser;
    }

    /**
     * @param \FosUser $iduser
     */
    public function setIduser($iduser)
    {
        $this->iduser = $iduser;
    }
    public function __toString()
    {
      return (string) $this->iduser=getId();
    }



}

