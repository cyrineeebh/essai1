package com.vermeg.settlementModule.instructionManager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vermeg.settlementModule.model.Instruction;


public interface InstructionRepository extends JpaRepository<Instruction, Long> {

}
