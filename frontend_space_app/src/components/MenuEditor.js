import React, { useState, useEffect } from "react";
import {
  Button,
  Card,
  Alert,
  CardTitle,
  CardBody,
  FormGroup,
  Input,
  Container,
  Row,
  Spinner,
  Col,
  Nav,
  NavLink,
  NavItem,
} from "reactstrap";
export const MenuEditor = ({ editor }) => {
    if (!editor) {
      return null;
    }
  
    return (
      <Nav>
        <NavItem>
          <NavLink
            href="#"
            onClick={() => editor.chain().focus().toggleBold().run()}
            className={editor.isActive("bold") ? "is-active" : ""}
          >
            {" "}
            <i class="fas fa-bold"></i>
          </NavLink>
        </NavItem>
  
        <NavItem>
          <NavLink
            href="#"
            onClick={() => editor.chain().focus().toggleItalic().run()}
            className={editor.isActive("italic") ? "is-active" : ""}
          >
            <i class="fas fa-italic"></i>
          </NavLink>
        </NavItem>
        <NavItem>
          <NavLink
            href="#"
            onClick={() => editor.chain().focus().toggleStrike().run()}
            className={editor.isActive("strike") ? "is-active" : ""}
          >
            <i class="fas fa-strikethrough"></i>
          </NavLink>
        </NavItem>
        <NavItem>
          <NavLink
            href="#"
            onClick={() => editor.chain().focus().toggleCode().run()}
            className={editor.isActive("code") ? "is-active" : ""}
          >
            <i class="fas fa-code"></i>
          </NavLink>
        </NavItem>
        <NavItem>
          <NavLink
            href="#"
            onClick={() => editor.chain().focus().unsetAllMarks().run()}
          >
            <i class="fas fa-edit"></i>
          </NavLink>
        </NavItem>
  
        <NavItem>
          <NavLink
            href="#"
            onClick={() => editor.chain().focus().setParagraph().run()}
            className={editor.isActive("paragraph") ? "is-active" : ""}
          >
            <i class="fas fa-paragraph"></i>
          </NavLink>
        </NavItem>
  
        <NavItem>
          <NavLink
            href="#"
            onClick={() =>
              editor.chain().focus().toggleHeading({ level: 1 }).run()
            }
            className={
              editor.isActive("heading", { level: 1 }) ? "is-active" : ""
            }
          >
            <b>H1 </b>
          </NavLink>
        </NavItem>
  
        <NavItem>
          <NavLink
            href="#"
            onClick={() =>
              editor.chain().focus().toggleHeading({ level: 2 }).run()
            }
            className={
              editor.isActive("heading", { level: 2 }) ? "is-active" : ""
            }
          >
            <b>H2</b>
          </NavLink>
        </NavItem>
  
        <NavItem>
          <NavLink
            href="#"
            onClick={() =>
              editor.chain().focus().toggleHeading({ level: 3 }).run()
            }
            className={
              editor.isActive("heading", { level: 3 }) ? "is-active" : ""
            }
          >
            <b>H3 </b>
          </NavLink>
        </NavItem>
        <NavItem>
          <NavLink
            href="#"
            onClick={() =>
              editor.chain().focus().toggleHeading({ level: 4 }).run()
            }
            className={
              editor.isActive("heading", { level: 4 }) ? "is-active" : ""
            }
          >
            <b>H4 </b>
          </NavLink>
        </NavItem>
        <NavItem>
          <NavLink
            href="#"
            onClick={() =>
              editor.chain().focus().toggleHeading({ level: 5 }).run()
            }
            className={
              editor.isActive("heading", { level: 5 }) ? "is-active" : ""
            }
          >
            <b>H5 </b>
          </NavLink>
        </NavItem>
        <NavItem>
          <NavLink
            href="#"
            onClick={() =>
              editor.chain().focus().toggleHeading({ level: 6 }).run()
            }
            className={
              editor.isActive("heading", { level: 6 }) ? "is-active" : ""
            }
          >
            <b>H6 </b>
          </NavLink>
        </NavItem>
  
        <NavItem>
          <NavLink
            href="#"
            onClick={() => editor.chain().focus().toggleBulletList().run()}
            className={editor.isActive("bulletList") ? "is-active" : ""}
          >
            <i class="fas fa-list-ul"></i>
          </NavLink>
        </NavItem>
  
        <NavItem>
          <NavLink
            href="#"
            onClick={() => editor.chain().focus().toggleOrderedList().run()}
            className={editor.isActive("orderedList") ? "is-active" : ""}
          >
            <i class="fas fa-list-ol"></i>{" "}
          </NavLink>
        </NavItem>
  
        <NavItem>
          <NavLink
            href="#"
            onClick={() => editor.chain().focus().toggleCodeBlock().run()}
            className={editor.isActive("codeBlock") ? "is-active" : ""}
          >
            <i class="fas fa-file-code"></i>{" "}
          </NavLink>
        </NavItem>
  
        <NavItem>
          <NavLink
            href="#"
            onClick={() => editor.chain().focus().toggleBlockquote().run()}
            className={editor.isActive("blockquote") ? "is-active" : ""}
          >
            <i class="fas fa-quote-right"></i>{" "}
          </NavLink>
        </NavItem>
  
        <NavItem>
          <NavLink
            href="#"
            onClick={() => editor.chain().focus().setHorizontalRule().run()}
          >
            <i class="fas fa-arrows-alt-h"></i>{" "}
          </NavLink>
        </NavItem>
  
        <NavItem>
          <NavLink href="#" onClick={() => editor.chain().focus().undo().run()}>
            <i class="fas fa-undo"></i>
          </NavLink>
        </NavItem>
        <NavItem>
          <NavLink href="#" onClick={() => editor.chain().focus().redo().run()}>
            <i class="fas fa-redo-alt"></i>
          </NavLink>
        </NavItem>
      </Nav>
    );
  };
export default MenuEditor;