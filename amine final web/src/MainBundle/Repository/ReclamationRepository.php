<?php

namespace MainBundle\Repository;

/**
 * ReclamationRepository
 *
 * This class was generated by the Doctrine ORM. Add your own custom
 * repository methods below.
 */
class ReclamationRepository extends \Doctrine\ORM\EntityRepository
{
   // public function myfindAll($titre){
    //    $query =$this->getEntityManager()
      //      ->createQuery("SELECT C FROM ClubBundle:Club c WHERE c.titre='$titre'");
    //}
    public function rechercheSujet11($sujet11){
        $query =$this->getEntityManager()
            ->createQuery("SELECT c FROM MainBundle:Reclamation c WHERE c.sujet11='$sujet11'");
        return $query->getResult();
    }
}