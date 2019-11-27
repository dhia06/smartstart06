<?php

namespace MainBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Reclamation
 *
 * @ORM\Table(name="reclamation")
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


}

