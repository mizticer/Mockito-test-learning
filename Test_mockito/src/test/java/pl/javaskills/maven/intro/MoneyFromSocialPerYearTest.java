package pl.javaskills.maven.intro;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Testing class MoneyFromSocialPerYear")
@ExtendWith(MockitoExtension.class)
public class MoneyFromSocialPerYearTest {
    @InjectMocks
    private MoneyFromSocialPerYear cut;
    @Mock
    private TaxForNoChildren taxForNoChildrenMock;

    @Test
    @DisplayName("should return 12000 when child number is two")
    public void test1(){
        //given
        int child=2;
        //when
        int result= cut.calculate(child);
        //then
        Mockito.verifyNoMoreInteractions(taxForNoChildrenMock);
        assertEquals(12000,result);
    }
    @Test
    @DisplayName("should return -1000 when child number is zero")
    public void test2(){
        //given
        int child=0;
        int tax=-1000;
        BDDMockito.given(taxForNoChildrenMock.payTaxPerYear()).willReturn(tax);
        //when
        int result=cut.calculate(child);
        //then
        Mockito.verify(taxForNoChildrenMock).payTaxPerYear();
        assertEquals(-1000,result);

    }
    @Test
    @DisplayName("should return -500 when child number is zero")
    public void test3(){
        //given
        int child=0;
        int tax=-500;
        BDDMockito.given(taxForNoChildrenMock.payTaxPerYear()).willReturn(tax);
        //when
        int result=cut.calculate(child);
        //then
        Mockito.verify(taxForNoChildrenMock).payTaxPerYear();
        assertEquals(-500,result);

    }
    @Test
    @DisplayName("should return 0 when child number is negative ")
    public void test4(){
        //given
        int child=-2;
        //when
        int result=cut.calculate(child);
        //then
        assertEquals(0,result);

    }



}
