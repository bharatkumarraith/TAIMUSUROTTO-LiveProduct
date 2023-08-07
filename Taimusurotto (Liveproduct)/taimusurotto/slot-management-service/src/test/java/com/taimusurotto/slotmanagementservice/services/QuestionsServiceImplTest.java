//package com.taimusurotto.slotmanagementservice.services;
//
//import com.taimusurotto.slotmanagementservice.domain.*;
//import com.taimusurotto.slotmanagementservice.repositories.*;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.time.LocalDate;
//import java.time.LocalTime;
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.ArgumentMatchers.anyInt;
//import static org.mockito.Mockito.when;
//
//@ExtendWith(MockitoExtension.class)
//@Slf4j
//class QuestionsServiceImplTest {
//
//    @Mock
//    AdminRepository adminRepository;
//
//    @Mock
//    SlotRepository slotRepository;
//
//    @Mock
//    InterviewerRepository interviewerRepository;
//
//    @Mock
//    MasterTableRepository masterTableRepository;
//
//    @Mock
//    IntervieweeRepository intervieweeRepository;
//
//    @InjectMocks
//    QuestionsServiceImpl questionsService;
//
//
//    Admin admin;
//    Slot slot;
//    Interviewer interviewer;
//    MasterTable masterTableData;
//    List<Slot> slots;
//    List<Integer> slot_ids, interviewee_ids;
//    List<MasterTable> masterTableSlots;
////    Set<Integer> interviewerIds;
//    Interviewee interviewee;
//
//
//
//
//    @BeforeEach
//    public void setUp(){
//        admin = new Admin(1,"Mehul","Admin@1234");
//        slot = new Slot(1, LocalDate.now(), LocalTime.now(),LocalTime.now(),null,5,0,3);
//        interviewer = new Interviewer(1,"Mehul","Mahajan","Mahajan214@gmail.com",9682101021L);
//        interviewee = new Interviewee(1,"Mehul","Mahajan","Mahajan213@gmail.com",9682101021L);
//        masterTableData = new MasterTable(1,null,null,slot,"Open",null,null,null,null);
//        slots = new ArrayList<>();
//        slots.add(slot);
//        slot_ids = new ArrayList<>();
//        slot_ids.add(slot.getSlot_Id());
//        masterTableSlots = new ArrayList<>();
//        masterTableSlots.add(masterTableData);
//        interviewee_ids = new ArrayList<>();
//        interviewee_ids.add(interviewee.getIntervieweeID());
////        interviewerIds = new HashSet<>();
////        interviewerIds.add(interviewer.getInterviewerID());
//    }
//
//    @AfterEach
//    public void tearDown(){
//        admin = null;
//        slot = null;
//        interviewer = null;
//        masterTableData = null;
//        slots = null;
//        slot_ids = null;
//        masterTableSlots = null;
//    }
//
//    @Test
//    void countCandidatesInterviewedForSlotId() {
//        when(slotRepository.findSlotIdsForSlotDate(LocalDate.now())).thenReturn(slot_ids);
//        when(masterTableRepository.countBookedCandidates(anyInt())).thenReturn(0);
//        assertEquals("On "+LocalDate.now()+" there is no booking for slot Id - "+slot.getSlot_Id(),questionsService.CountCandidatesInterviewedForSlotId(1,LocalDate.now()));
//    }
//
//    @Test
//    void nameOfIntervieweesForSlotId() {
//        when(slotRepository.findSlotIdsForSlotDate(LocalDate.now())).thenReturn(slot_ids);
//        when(masterTableRepository.findIntervieweeIdOfCandidatesForSlotId(1)).thenReturn(interviewee_ids);
//        when(intervieweeRepository.findNameForId(1)).thenReturn("Mehul");
//        assertEquals("Name of interviewees ---> "+List.of("Mehul")+" Booked for slot - "+1,questionsService.nameOfIntervieweesForSlotId(1,LocalDate.now()));
//    }
//
//    @Test
//    void totalCandidatesThatCanBEInterviewed() {
//        when(slotRepository.findSlotIdsForSlotDate(LocalDate.now())).thenReturn(slot_ids);
//        when(masterTableRepository.countAllCandidates(1)).thenReturn(1);
//        assertEquals("Total number of candidates that can give interviewee on - "+LocalDate.now()+" ->"+1,questionsService.totalCandidatesThatCanBEInterviewed(LocalDate.now()));
//    }
//
//    @Test
//    void totalNumberOfSlotsForSlotDate() {
//        when(slotRepository.findSlotIdsForSlotDate(LocalDate.now())).thenReturn(slot_ids);
//        assertEquals("Total number of slots for date - "+LocalDate.now()+" are -->"+1,questionsService.totalNumberOfSlotsForSlotDate(LocalDate.now()));
//    }
//
//    @Test
//    void totalNumberOfInterviewerAvailable() {
//        when(slotRepository.findSlotIdsForSlotDate(LocalDate.now())).thenReturn(slot_ids);
//        when(masterTableRepository.findInterviewerAvailable(1)).thenReturn(interviewee_ids);
//        assertEquals("total number of interviewer available on "+LocalDate.now()+" --> "+1,questionsService.totalNumberOfInterviewerAvailable(LocalDate.now()));
//    }
//
//    @Test
//    void slotUtilization() {
//        when(slotRepository.getSlotsByDate(LocalDate.now())).thenReturn(slots);
//        when(masterTableRepository.findAllBySlotId(1)).thenReturn(masterTableSlots);
////        assertEquals("Total Slots created were : "+1+". Open Slots were : "+1+". Booked Slots were : "
////                +0+". Cancelled Slots were : "+0+". Utilization : "+0,questionsService.slotUtilization(LocalDate.now()));
//    }
//
//    @Test
//    void singleSlotStats() {
//        when(masterTableRepository.findAllBySlotId(1)).thenReturn(masterTableSlots);
//        assertEquals("Booking : "+0+". Available : "+1+". Cancelled : "+0+".",questionsService.singleSlotStats(1));
//    }
//
//    @Test
//    void totalCancelledSlotsForADay(){
//        when(slotRepository.findSlotIdsForSlotDate(any())).thenReturn(slot_ids);
//        when(masterTableRepository.findNumberOfCancelledSlotsForSlotId(anyInt())).thenReturn(4);
//        assertEquals(4,questionsService.totalCancelledSlotsForADay(LocalDate.now()));
//    }
//}