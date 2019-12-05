<?php

namespace MainBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Participer
 *
 * @ORM\Table(name="participer", indexes={@ORM\Index(name="iduser", columns={"iduser"}), @ORM\Index(name="idformation", columns={"idformation"})})
 * @ORM\Entity
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

