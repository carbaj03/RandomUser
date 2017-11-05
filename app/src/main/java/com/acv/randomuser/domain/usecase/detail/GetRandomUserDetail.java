package com.acv.randomuser.domain.usecase.detail;


import com.acv.randomuser.data.RandomUserRepository;
import com.acv.randomuser.domain.error.LocalGatewayException;
import com.acv.randomuser.domain.model.Id;
import com.acv.randomuser.domain.model.RandomUser;
import com.acv.randomuser.domain.usecase.InternalUseCaseError;
import com.acv.randomuser.domain.usecase.UseCase;
import com.acv.randomuser.domain.usecase.UseCaseError;
import com.acv.randomuser.domain.usecase.UseCaseResponse;

public class GetRandomUserDetail implements UseCase<UseCaseResponse<RandomUser>> {
    private RandomUserRepository repository;
    private Id id;

    public GetRandomUserDetail(RandomUserRepository repository) {
        this.repository = repository;
    }

    public void setId(Id id){
        this.id = id;
    }

    @Override
    public UseCaseResponse<RandomUser> call() {
        try {
            return fromLocal();
        } catch (LocalGatewayException ex) {
            return responseError(new GetRandomUserDetailError());
        } catch (Exception ex) {
            return responseError(new InternalUseCaseError());
        }
    }

    private UseCaseResponse<RandomUser> fromLocal() throws LocalGatewayException {
        RandomUser randomUsers = repository.obtainBy(id);
        if (randomUsers == null) {
            throw new LocalGatewayException();
        } else {
            return responseModel(randomUsers);
        }
    }

    private UseCaseResponse<RandomUser> responseModel(final RandomUser randomUser) {
        return new UseCaseResponse<>(randomUser);
    }

    private UseCaseResponse<RandomUser> responseError(UseCaseError error) {
        return new UseCaseResponse<>(error);
    }
}
