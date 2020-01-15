<?php

namespace FormationBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Participer
 *
 * @ORM\Table(name="participer")
 * @ORM\Entity(repositoryClass="FormationBundle\Repository\ParticiperRepository")
 */
class Participer
{
    /**
     * @var integer
     *
     * @ORM\Column(name="idparticiper", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idparticiper;

    /**
     * @return int
     */
    public function getIdparticiper()
    {
        return $this->idparticiper;
    }

    /**
     * @param int $idparticiper
     */
    public function setIdparticiper($idparticiper)
    {
        $this->idparticiper = $idparticiper;
    }

    /**
     * @return int
     */
    public function getIduser()
    {
        return $this->iduser;
    }

    /**
     * @param int $iduser
     */
    public function setIduser($iduser)
    {
        $this->iduser = $iduser;
    }

    /**
     * @return int
     */
    public function getIdformation()
    {
        return $this->idformation;
    }

    /**
     * @param int $idformation
     */
    public function setIdformation($idformation)
    {
        $this->idformation = $idformation;
    }

    /**
     * @var integer
     *
     * @ORM\Column(name="iduser", type="integer", nullable=false)
     */
    private $iduser;

    /**
     * @var integer
     *
     * @ORM\Column(name="idformation", type="integer", nullable=false)
     */
    private $idformation;


}
