package com.danilo_alves.simplified_erp.application.usecase;

public interface UseCase<InputDTO, OutputDTO> {
    OutputDTO execute(InputDTO input);
}
