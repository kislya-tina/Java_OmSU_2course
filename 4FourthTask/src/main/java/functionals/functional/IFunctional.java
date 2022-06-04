package functionals.functional;


import functionals.functionsOfSingleArgument.IFuncOnSegment;

public interface IFunctional <T extends IFuncOnSegment> {
    double getValue(T function);
}